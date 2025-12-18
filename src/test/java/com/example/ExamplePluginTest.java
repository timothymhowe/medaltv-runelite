package com.example;

import com.medaltv.MedaltvPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import org.junit.Test;

public class ExamplePluginTest
{
	@Test
	public void sanity(){
		System.out.println("Hello world! 🤣");
		assert true;
	}

	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MedaltvPlugin.class);
		RuneLite.main(args);
	}
}

