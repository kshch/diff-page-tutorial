package ut.com.kshch.confluence.plugins.diff.page;

import org.junit.Test;
import com.kshch.confluence.plugins.diff.page.api.MyPluginComponent;
import com.kshch.confluence.plugins.diff.page.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}