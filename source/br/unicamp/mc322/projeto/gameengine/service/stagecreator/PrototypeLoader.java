package br.unicamp.mc322.projeto.gameengine.service.stagecreator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.LinkedList;

public class PrototypeLoader 
{
    public StagePrototype load(String dir)
    {
        ///@todo alterar para referência da pasta definida no construtor
        File file = null;
        try
        {
            URL url = this.getClass().getResource(dir);
            file = new File(url.toURI());
        }
        catch(Exception e)
        {
            ///@todo tratar exceções
        }
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = null;
        Document doc = null;

        try
        {   
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ///@todo lidar com exceções caso o arquivo não seja lido
        }
        
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("entity");

        LinkedList<EntityPrototype> prototypeList = new LinkedList<EntityPrototype>();

        for(int i = 0; i< nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);

            prototypeList.add(loadEntityPrototype(node));
        }

        ///@todo precisa criar um construtor para inserir um índice para o estágio, e carregar o índice do arquivo
        StagePrototype stagePrototype = new StagePrototype();

        stagePrototype.addPrototype(prototypeList);

        return stagePrototype;

    }

    private EntityPrototype loadEntityPrototype(Node node) 
    {
        Element element = (Element) node;

        String className = element.getAttribute("classname");

        Class prototypeClass;

        try
        {
            prototypeClass = Class.forName(className);
        }
        catch(ClassNotFoundException e)
        {
            ///@todo tratar exceções
            return null;
        }

        NodeList poseNode = element.getElementsByTagName("pose");

        Pose pose;
        

        if(poseNode.getLength() == 0)
        {
            pose = new Pose();
        }
        else
        {
            pose = loadPose(poseNode.item(0));
        }

        LinkedList<Node> argNode = getArgNodes(node);
        

        Object[] arg = loadArg(argNode);


        return new EntityPrototype(prototypeClass, pose, arg);
    }

    private Pose loadPose(Node node)
    {
        Element poseElement = (Element) node;

        float x = Float.parseFloat(poseElement.getAttribute("x"));
        float y = Float.parseFloat(poseElement.getAttribute("x"));
        float angle = Float.parseFloat(poseElement.getAttribute("angle"));

        return new Pose(x,y,angle);
    }

    private LinkedList<Node> getArgNodes(Node node)
    {
        Element element = (Element) node;

        NodeList children = element.getChildNodes();

        LinkedList<Node> argNode = new LinkedList<Node>();

        for(int i = 0; i< children.getLength(); i++)
        {
            if(children.item(i).getNodeName() == "arg")
            {
                argNode.add(children.item(i));
            }
        }

        return argNode;
    }

    /**
     * Carrega os argumentos do EntityProtype no arquivo
     * @param nodeList
     * @return
     */
    private Object[] loadArg(LinkedList<Node> nodeList)
    {  
        if(nodeList.size() == 0)
        {
            return new Object[0];
        }

        LinkedList<Object> argList = new LinkedList<Object>();

        for(int i = 0; i<nodeList.size(); i++)
        {
            argList.add(loadArg(nodeList.get(i)));
        }

        return argList.toArray(new Object[argList.size()]);

    }

    /**
     * Carrega uma argumento do EntityPrototype no arquivo
     * @param node
     * @return
     */
    private Object loadArg(Node node)
    { 
        Element element = (Element) node;
        String className = element.getAttribute("classname");
        Class argClass;

        Object arg = null;
        String stringValue = element.getAttribute("value");


        switch(className)
        {
            case "Integer":
                arg = Integer.parseInt(stringValue);
                return arg;

            case "String":
                arg = stringValue;
                return arg;

            case "Float":
                arg = Float.parseFloat(stringValue);
                return arg;

        }

        try
        {
            argClass = Class.forName(className);
        }
        catch(ClassNotFoundException e)
        {
            ///@todo tratar exceções
            return null;
        }


        LinkedList<Node> subArgNode = getArgNodes(node);
        
        Object[] subArgList = loadArg(subArgNode);
        Class[] subArgClassList = new Class[subArgList.length];

        for(int i = 0; i< subArgList.length; i++)
        {
            subArgClassList[i] = subArgList[i].getClass();
        }

        try
        {
            Constructor<?> constructor = argClass.getConstructor(subArgClassList);        

            arg =  constructor.newInstance(subArgList);
        }
        catch(Exception e)
        {
            ///@todo Tratar exceções
            e.printStackTrace();
        }


        return arg;
    }
}