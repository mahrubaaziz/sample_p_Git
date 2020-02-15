package dataProviderFactorry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;// we are working twith prop file we are creating obj and ref it
	
	public ConfigDataProvider(){// create constructor
		try{
			pro=new Properties();// in case if we do not read the file
			//load the file from dir and read them
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/ConfigurationFile/config.properties")));
			}catch(IOException e){//catvh the error and print them
				System.out.println("Unable to load Properties file"+e.getMessage());
			}
		
	}
	public String getBrowser()//
	{
		return pro.getProperty("browser");
	}
	public String getStagingURL()
	{
		return pro.getProperty("stagingURL");
	}
	public String getValueFromProperties(String key)
	{
		return pro.getProperty(key);
	}

}
