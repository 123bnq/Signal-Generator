 _____ _                   _   _____                           _             
/  ___(_)                 | | |  __ \                         | |            
\ `--. _  __ _ _ __   __ _| | | |  \/ ___ _ __   ___ _ __ __ _| |_ ___  _ __ 
 `--. \ |/ _` | '_ \ / _` | | | | __ / _ \ '_ \ / _ \ '__/ _` | __/ _ \| '__|
/\__/ / | (_| | | | | (_| | | | |_\ \  __/ | | |  __/ | | (_| | || (_) | |   
\____/|_|\__, |_| |_|\__,_|_|  \____/\___|_| |_|\___|_|  \__,_|\__\___/|_|   
          __/ |                                                              
         |___/                                                               

#################################################################################
#	Authors:								#
#		Bui Nhat Quang							#
#	 	Nguyen Pham Nhat Huy						#
#										#
#										#
#################################################################################

.########..########....###....########..##.....##.########
.##.....##.##.........##.##...##.....##.###...###.##......
.##.....##.##........##...##..##.....##.####.####.##......
.########..######...##.....##.##.....##.##.###.##.######..
.##...##...##.......#########.##.....##.##.....##.##......
.##....##..##.......##.....##.##.....##.##.....##.##......
.##.....##.########.##.....##.########..##.....##.########

********************** SignalGeneratorServer.jar ***********************************

Server file - server socket must be run before running client side.
input IP address and Port, then press start Server.
The IP addess must be either localhost or the IP address of the computer in the LAN.
The Port number must be from 1 to 65535.
If the wrong inputs are given, there should be a warning dialog.
The server must be remained open when operating with the client.
The server socket must be restart when rerun the client side.
However, it can be recconnected many times when restarting client socket.
Before closing server side, make sure to disconnect the socket and then press x on the title bar.
************************************************************************************


********************** SignalGeneratorClient.jar ***********************************
Client file - must run after opening the connection from server.
input IP address and Port, then press Connect.
The IP addess must be either localhost or the IP address of the computer in the LAN.
The Port number must be from 1 to 65535.
If the wrong inputs are given, there should be a warning dialog.
After pressing Connect, a config frame pops up.
There are 3 tabs for each signal configuration (sine, square wave, sawtooth wave)
After changing the values, click Apply to see the signal.
Another frame pops up and shows the signal in range of 0 to 100 ms.
The changed signal can only be displayed when press Apply.
To close the client, please make sure to press disconnect on the main windows,
then click x on the title bar.

************************************************************************************