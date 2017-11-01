package Framework;

import java.lang.reflect.Method;

public class BaseTest
{
    public void Run()
    {
        Method[] methods = this.getClass().getMethods();
        for (int i = 0; i < methods.length; ++i)
        {
            Method method = methods[i];
            String methodName = method.getName();
            if (methodName.startsWith("Test") == false)
                continue; 
            
            try
            {
                Utility.Print(methodName + " Begin");
                method.invoke(this, new Object[0]);
                Utility.Print(methodName + " End");
            } 
            catch (Exception e)
            {
                Utility.Print(e.getMessage());
            }
        }
    }
}