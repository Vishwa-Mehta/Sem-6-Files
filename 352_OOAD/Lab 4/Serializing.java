import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
  
public class Serializing {
    public static void main(String[] args)
    {
        HashMap<String, String> config = new HashMap<>();
  
        try {
            File file = new File("config.cfg");
			if (!file.exists()) {
				file.createNewFile();
				FileOutputStream myFileOutStream = new FileOutputStream(file);

				ObjectOutputStream myObjectOutStream = new ObjectOutputStream(myFileOutStream);

				config.put("Path:", null);
				config.put("Version:", null);
				config.put("System_Name:", null);
				myObjectOutStream.writeObject(config);
			}
			else {
				FileOutputStream myFileOutStream = new FileOutputStream(file);
  
				ObjectOutputStream myObjectOutStream = new ObjectOutputStream(myFileOutStream);
				String path;
				String ver;
				String sysname;
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the path:");
				path = sc.next();	
				System.out.println("Enter the version:");
				ver = sc.next();	
				System.out.println("Enter the system name:");
				sysname = sc.next();	

				config.put("Path:", path);
				config.put("Version:", ver);
				config.put("System_Name:", sysname);
				//config.put("Path:", "Vishwa/Documents/Vishwa_PES/Sem6/352_OOAD/PES2UG20CS389");
				//config.put("Version:", "17.0.6");
				//config.put("System_Name:", "Acer-Vishwa");
				myObjectOutStream.writeObject(config);
            myObjectOutStream.close();
            myFileOutStream.close();
			}
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
