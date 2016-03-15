Deploying to the microcloud
===========================

## Creating a JAR file using Eclipse

1. Right-click on the Project you wish to package.
2. Select `Java > Runnable JAR file`
3. Under `Launch configuration:`, select the appropriate run configuration. Because you are creating a runnable jar file, the run configuration specifices the main method that will be executed when this JAR file is run. This assumes that you have run this specific main method at least one through Eclipse. To package your `GradeBookServer`, you will select the configuration: `GradeBookServer - GradeServer`.
4. Under `Export destination:` select the appropriate directory and give your JAR file an appropriate name. Generally, save the JAR file in the top-level project directory. For the `GradeBookServer`, create a `gradebook.jar` file in the `GradeServer` directory.
5. Under `Library Handling:` *make absolutely certain* to select `Package required libraries into generated JAR`.

## Using SCP

SCP or secure copy allows you to transfer files from one computer, in this case, your laptop/desktop, to another computer, in this case the CS department file server.

First, it is highly recommended you watch the videos available on the CS support page: [Using SCP](http://www.cs.usfca.edu/support.html#ftp).

You will need to transfer `gradebook.jar` *and* `grades.json` to your CS directory.

In my case, I first logged into `stargate` [using ssh](http://www.cs.usfca.edu/support.html#login) and created a directory `cs212/gradebook` in my home directory.

Then, from my laptop, I opened a terminal window and changed into the directory where my JAR and json files were located.

Next, I used the following commands to copy the files to my CS directory:

```
scp gradebook.jar srollins@stargate.cs.usfca.edu:/home/srollins/cs212/gradebook/.
scp grades.json srollins@stargate.cs.usfca.edu:/home/srollins/cs212/gradebook/.
```

The first command says to copy the `gradebook.jar` file from my local directory into my `/home/srollins/cs212/gradebook/` directory on stargate. The `.` at the end says to give it the same name in the remote directory, so I'll end up with two new files in my CS directory, `/home/srollins/cs212/gradebook/gradebook.jar` and `/home/srollins/cs212/gradebook/grades.json`.

## SSH to the microcloud and run the program

Now that the JAR and input files are available from the microcloud node, you will need to SSH to your microcloud node.

The microcloud nodes are behind the CS firewall. This means you need to first ssh to stargate, then ssh to your microcloud node from stargate.

It is recommended that you watch the videos on SSH available on the CS support page: [Using SSH](http://www.cs.usfca.edu/support.html#login).

In my case, I used the following two commands to log in to [my assigned node](https://github.com/CS212-S16/lectures/blob/master/notes/mcassignments.md) - mc01:

```
ssh srollins@stargate.cs.usfca.edu
ssh mc01.cs.usfca.edu
```

From any microcloud node, you will be able to access your home directory, so you can `cd` into the appropriate subdirectory, for example `cs212/gradebook`.

Once you are in the correct directory, use [nohup](https://en.wikipedia.org/wiki/Nohup) to execute your program. This will ensure that your program continues to run even if you log out of the microcloud node. The command I used to do this was as follows:

``` 
nohup java -jar gradebook.jar &
```

### Exiting the program

`nohup` allows your program to continue running even if you log out, and `&` says to run your program in the background. 

Unfortunatelly, this makes it a bit difficult to exit your program. If you ran your program with the command `java -jar gradebook.jar` then you could easily use CTRL-C to exit the program. Not so with `nohup` and `&`.

If you make changes, redeploy, and try to run your program again you will find that you will get an error that the port is already in use. Only one program may listen on a given port at a time.

To find and kill a previous run of your program, use the following commands:

```
ps aux | grep java
```

This command lists all processes running and *pipes* the output of that into the `grep` command that will search for the keyword *java*. This will show you something like the following:

```
srollins 13983  0.1  0.6 7768088 104132 ?      Sl   12:37   0:02 java -jar gradebook.jar
```

This gives you the *process ID*, which you can use to kill the process as follows:

```
kill -9 13983
```

## SSH Tunnel

Because the microcloud is behind the CS firewall, you will not be able to directly access your server unless you are connected to the CSLabs network from Harney.

If you wish to test your program while connected to USF Wireless or another network, you will need to set up an SSH tunnel.

Google has several links to resources that will help you [set up an ssh tunnel using putty on windows](https://www.google.com/search?q=putty+ssh+tunnel&oq=putty+ssh+tunnel&aqs=chrome..69i57j0l5.4199j0j7&sourceid=chrome&es_sm=91&ie=UTF-8).

On the Mac, you can use a command similar to the following:

```
ssh -L 9000:mc01.cs.usfca.edu:8080 srollins@stargate.cs.usfca.edu
```

This command specifies that you want to forward traffic going to port 9000 on the local machine to mc01 port 8080 via the *gateway* stargate.

You will need to replace `mc01.cs.usfca.edu:8080` with your assigned microcloud node and port. You will also replace `srollins` with your username.

Finally, the `9000` is the port you wish to use locally. This can be anything over 1024 as long as you are consistent with how it is used.

Specifically, the command above assumes that I have logged into mc01.cs.usfca.edu and launched my server to listen on port 8080. 

In the browser on my local machine (i.e., my laptop connected to any network), I will open a browser and load `http://localhost:9000/all`. The browser will send the traffic to port 9000 on my local host, and the tunnel redirects that traffic to mc01 port 8080 via stargate!
