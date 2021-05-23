package automation.utils;

import java.io.File;

public class PathUtils {

	public static String getBasePath() {
		String basePath;
		try {
			basePath = (new File(".")).getCanonicalPath();
		} catch (Exception var3) {
			throw new AutomationError("failure getting path of machine");
		}
		return basePath;

	}
}
