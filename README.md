##Nether+ Mod for Minecraft

Currently compatible with Minecraft version 1.3.2.


###Compiling

You need to have Apache Ant installed(http://ant.apache.org/) and you must have already decompiled Minecraft using MCP and the Forge source installer (http://jenkins.minecraftforge.net:7070/job/forge/). You must install this entire repo into your \MCP_Folder\src directory. Once that is doneyou can simply run build.bat if you are on Windows or run:

    ant clean package
    
This will automatically compile and build the jar for you which will be put into \MCP_Folder\build\dist. Note: For this to work, you must have added Ant to your "PATH".