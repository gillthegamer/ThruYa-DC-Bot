# ThruYa-Discord-Bot

Discord Bot based on https://github.com/discord-jda/JDA. Customized Discord Bot for the [ThruYa Discord Server](https://discord.gg/pngUPxr6Wj).

# Requirements

- Java 17
# How it works

Install Java on your System an execute the java application. The default config is the config.properties and is in the same directory as the java application. it needs to have the `TOKEN` an the `PREFIX`\
eg. (Default config)\
`java -jar ThruYa-DC-Bot-1.0.jar`\
If you want to have your own config create a .properties file an at the `-s` Parameter.\
eg.\
`java -jar ThruYa-DC-Bot-1.0.jar -s config.properties`
# How to create the config file
Put in the a config.properties the Bot TOKEN an the prefix\
eg.
```
TOKEN={Your Bot Token}
PREFIX={Your preferd Prefix}
```
### Additional parameter
```
LOGCHANNEL={logs channel ID}
WELCOMECHANNEL={welcome channel ID}
RULECHANNEL ={rule channel ID}
RULECHECKEMOJI ={rule check Emoji}
```
### How to get the Channel ID
Activate the Developer Mode on your Discord Client an right click on the channel there you can copy the channel ID. The Emoji must be on in Unicode Hex format.\
eg. `U+2705` ✅
# Devs
[gillthegamer](https://github.com/gillthegamer) 
