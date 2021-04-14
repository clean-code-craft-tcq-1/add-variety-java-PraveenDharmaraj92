package factory;

import alert.IAlerter;

public interface IObjectFactory {
	
	
	public default Object getObject(String className, String packageName){
		try {
			Class<IAlerter> breachChecker = (Class<IAlerter>) Class
					.forName(packageName + "." + className);
			return breachChecker.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
