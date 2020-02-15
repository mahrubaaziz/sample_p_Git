package dataProviderFactorry;

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();//its a config class ref obj class we created in base class
		return config;//we are returning config
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel =new ExcelDataProvider();
		return excel;
	}

}
