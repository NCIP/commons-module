/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.audit.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import edu.wustl.common.exception.ErrorKey;
import edu.wustl.dao.exception.AuditException;

/**
 * This class generates the audit metadata xml for given package.
 * @author kunal_kamble
 *
 */
public class AuditXMLGenerator
{
	public static boolean excludeAssociation;
	public static void main(String[] args) throws AuditException
	{
		int classCounter = generateAuditXML(args);
		System.out.println("Totatl number of clsses:" + classCounter);
	}

	/**
	 * @param args [0]: package name , [1]: metadata file name
	 * @return number of classes processed
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws AuditException
	 */
	public static int generateAuditXML(String[] args) throws AuditException
	{

		int classCounter = 0;
		try
		{
			PrintWriter auditableXmlWriter = new PrintWriter(args[1]);
			auditableXmlWriter.println("<?xml version='1.0' encoding='utf-8'?>");
			auditableXmlWriter.println("<AuditableMetaData>");
			AuditXMLTagGenerator auditXMLGenerator = new AuditXMLTagGenerator();
			if(args.length >2)
			{
				excludeAssociation = Boolean.valueOf(args[2]);
			}

			for (Class class1 : getClasses(args[0]))
			{
				if (!class1.isInterface() && !class1.isEnum()
						&& !Modifier.isAbstract(class1.getModifiers()))
				{
					auditableXmlWriter.println(auditXMLGenerator
							.getAuditableMetatdataXMLString(class1.getName()));
					classCounter++;
				}
			}
			auditableXmlWriter.println("</AuditableMetaData>");
			auditableXmlWriter.close();
		}
		catch (FileNotFoundException e)
		{
			throw new AuditException(ErrorKey.getErrorKey("audit.xml.generation.error"),e,"");
		}


		return classCounter;
	}
	/**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     * @param packageName The base package
     * @return The classes
	 * @throws AuditException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName) throws AuditException{
    	ArrayList<Class> classes = new ArrayList<Class>();
    	try{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
    	}
		catch (ClassNotFoundException e)
		{
			throw new AuditException(ErrorKey.getErrorKey("audit.xml.generation.error"),e,"");
		}
		catch (IOException e)
		{
			throw new AuditException(ErrorKey.getErrorKey("audit.xml.generation.error"),e,"");
		}
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
