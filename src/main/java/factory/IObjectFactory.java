package factory;

import alert.IAlerter;

public interface IObjectFactory {
	
	
	public default Object getObject(String className, String packageName) throws Exception{
			Class<IAlerter> breachChecker = (Class<IAlerter>) Class
					.forName(packageName + "." + className);
			return breachChecker.newInstance();
	}

}
