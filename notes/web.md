HTML, the Web, and the Internet
====================================

# HTML
The [Hypertext Markup Language (HTML)](http://www.w3schools.com/html/html_intro.asp) is the language used to create web pages. It allows a programmer to specify how text should be displayed in the browser using **tags**. Tags specify formatting instructions such as display some text in bold, some text in italics, and some text centered.

```html
<html>
	<head>	
      <title>Sample Page</title>
    </head>
    <body>
    	<h1>This is a test page</h1>
    	<p>This is some <b>bold</b> text...and some <i>italic</i> text.</p>
    	<p>You can also have a <a href="http://www.cs.usfca.edu">link</a>.</p>
    	<hr/>
   </body>
</html>
```

Tags come in pairs. Start tags begin a block and end tags (starting with a forward slash) end a block. Everything from a start to an end tag forms an **element**. Some elements are empty (`<hr/>`). Valid tag names, for example `h1` and `p`, are defined by the HTML standard.

- `h1`...`h6` are heading tags
- `p` specifies a paragraph
- `a` tags can be used to specify links

Images may be included in a page using an `img` tag as below:

```
<img src="http://www.cs.usfca.edu/pic.jpg/> 
```

Comments are specified as below and are ignored when a page is displayed.

```
<!-- This is a comment. -->
```

Ordered (`ol`) and unordered (`ul`) lists are specified as follows:

```
<ul> 
    <li>...</li> <!-- each list item -->
</ul>
```

Tables are also quite useful:

```
<table border="1">	<tr>
		<td>row 1, cell 1</td>
		<td>row 1, cell 2</td>
	</tr>	<tr>
		<td>row 2, cell 1</td>
		<td>row 2, cell 2</td>
	</tr>
</table> 
```

Links are defined with the `a` tag.

```	
<a href="http://www.cs.usfca.edu">link</a>
```

This example opens the link in a new browser tab:

```
<a target=“_blank” href="http://www.cs.usfca.edu">link</a>
```

`href` and `target` are **attributes**, just as `border` is an attribute in the `table` element above. Attributes may be reordered.

```
<a href="http://www.cs.usfca.edu" target=“_blank” >link</a>
```

`script` elements allow you to specify [javascript](http://www.w3schools.com/js/) on your page. 

```
<script type="text/javascript">
	document.write("Hello World!")
</script> 
```

`style` elements allow you to specify inline [cascading style sheets](http://www.w3schools.com/html/html_css.asp), or inline styling information.

```		
<style>
  body {background-color:lightgray}
  h1   {color:blue}
  p    {color:green}
</style>
```

Finally, special characters, like the &, need to be escaped.

```
<p>CS 212 &amp; CS 245 are great classes!</p>
```

# The Web

> The World Wide Web (WWW) is an open source information space where documents and other web resources are identified by URLs, interlinked by hypertext links, and can be accessed via the Internet.

[https://en.wikipedia.org/wiki/World_Wide_Web](https://en.wikipedia.org/wiki/World_Wide_Web)

### Client/Server Model

The web is not the Internet, but a collection of documents or resources that may be accessed using the Internet. **Servers** are the computers that store those documents or resources. **Clients** are the computers that request those documents or resources. Typically, servers are "beefy" computers that are always connected to the Internet and clients are any other kind of device, including a laptop, a phone, or even a watch.

### URLs

The most common way to access a web page is to enter a [Uniform Resource Locator (URL)](https://docs.oracle.com/javase/tutorial/networking/urls/definition.html) into a browser. 

A URL specifies the *protocol* to use and the name of the *resource* to retrieve.

```
http://docs.oracle.com/javase/1.5.0/docs/api/java/net/URL.html
```

The URL above has several parts:

- `http` is the **protocol** to use to access this resource. `https` is another common protocol.
- `docs.oracle.com` is the **host**, or computer that will serve this web page.
- `javase/1.5.0/docs/api/java/net/URL.html` is the **path** to the resource we wish to access. This could be the path to a file the server will provide, or it could be a more general location of a *resource* available on the server.

```
https://www.google.com/search?q=url+path&oq=url+path&aqs=chrome..69i57.3123j0j4&sourceid=chrome&es_sm=91&ie=UTF-8
```

In this example, the protocol is `https`, the host is `www.google.com`, and the path is `/search`. Following the path are a set of **parameters**. These further identify the resource. The parameters begin with `&` and are a sequence of `key=value` pairs separated by `&`.

### Loading a Web Page

The basic steps to load a web resource are as follows:

1. Human enters the URL into the appropriate program on the client (e.g., types a URL into a browser window).
2. The client program translates the host into a numerical address that is unique to the server computer providing the page.
3. The client program makes a connection to the server using the address.
4. The client program requests the resource by providing the path and parameters.
5. The server returns the content to the client.
6. If the resource is in HTML, the client program uses the formatting information to display the page in the browser.

### DNS

It turns out that the first thing that happens when you type a URL into your browser and hit enter is that the host needs to be translated into an [Internet Protocol (IP)](https://en.wikipedia.org/wiki/IP_address) address. 

There are two versions of IP, IP version 4 and IP version 6. We are in the midst of a transition from v4 to v6, however you may be most familiar with IPv4 addresses. They look as follows:

```
138.202.170.2
```

An IPv4 address is a set of four numbers, each from 0-255 (bonus: how many bits are used to represent an IPv4 address?). 

The [Domain Name System](https://en.wikipedia.org/wiki/Domain_Name_System) is a lookup mechanism that translates a human-understandable host name, like www.cs.usfca.edu or www.nytimes.com, to an IP address.

When a client connects to a server, the client must use the server's IP address. Therefore, when a client loads a URL it first uses DNS to translate the host name to the IP address and then opens a connection to the host.

### HTTP

The [Hypertext Transfer Protocol](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol) is the language clients and servers use to communicate. You can implement a server using C# on Windows and access it via Safari running on a Mac as long as both the client and server are using valid HTTP. 

HTTP is a standard defined by the [Internet Engineering Task Force](https://en.wikipedia.org/wiki/Internet_Engineering_Task_Force). It defines the precise format of client requests and server responses. 

Common HTTP request types are `GET`, `POST`, `PUT`, `HEAD`, and `DELETE`. To retrieve a web page, a client will send a `GET` request. To provide form data, a client will typically send a `POST` request.

The following example uses the telnet program to connect to a web server and send an HTTP GET request.

```
saison:~ srollins$ telnet www.cs.usfca.edu 80
Trying 138.202.168.1...
Connected to www.cs.usfca.edu.
Escape character is '^]'.
GET /~srollins/index.html
```

A basic GET is `GET` followed by a path---the part of the URL that follows the host. Note that `GET` is case sensitive.

A request may also specify headers.

```
GET /test.html HTTP/1.1
Host: localhost:1024
User-Agent: Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.5; en-US; rv:1.9.1.3)
Gecko/20090824 Firefox/3.5.3
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-us,en;q=0.5
Accept-Encoding: gzip,deflate
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7
Keep-Alive: 300
Connection: keep-alive
Cookie: author=AnonymousCoward
Cache-Control: max-age=0
```

The response from the server will begin with a status line indicating whether the request was successful, and will be followed by headers and the body of the response.

```
HTTP/1.1 200 OK
Date: Thu, 17 Sep 2009 00:33:18 GMT
Server: Apache
Accept-Ranges: bytes
Cache-Control: max-age=60, private, private
Expires: Thu, 17 Sep 2009 00:34:05 GMT
Content-Type: text/html
Vary: Accept-Encoding,User-Agent
Content-Length: 99253
Connection: close
```

In addition to 200 OK, other common status codes include the following:

- 404 Not Found
- 500 Internal Error
- 301 Moved
- 403 Forbidden

There are several differences between HTTP version 1.0 and version 1.1, which is now commonly used. In particular, HTTP 1.1 allows persistent connections. This means you can make several requests over the same connection between client and server. To make a connection non-persistent, you must specify the `Connection: close` header. Also, in HTTP 1.1 requests you must specify the `Host:` header.

### Port Number

When using telnet to open the connection it was necessary to use the number 80. This is the **port** number. The IP address specifies the computer that will handle the request, and the port number specifies the application running on that computer. This allows the same server to run multiple applications that will serve clients. A computer, for example, might run both a web server and a mail server. The port number allows the network stack to determine which application should receive a given message that arrives from the Internet.

Web servers typically run on port 80. Unfortunately, without root permission on a computer you will not be able to run your web server on a port with a number lower than 1024. This means you will need to specify the port number in your URL. This is done by using `:port` after the host, for example something like the following:

```
http://mc01.cs.usfca.edu:8080/search
```

# The Internet

The Web is not the Internet. The [Internet](https://en.wikipedia.org/wiki/Internet) is a *network of networks* that connect billions of computing devices.

Networked communication over the Internet utilizes a *layered protocol stack*.
Each layer has well-defined responsibilities and relies upon the other layers to do their jobs. 

End hosts, like clients and servers, have five layers of functionality. Between two hosts are a series of other network components, including *routers* and *switches*. Those components do not have all five layers of functionality.

From https://en.wikipedia.org/wiki/Internet_protocol_suite:

![layers](https://upload.wikimedia.org/wikipedia/commons/c/c4/IP_stack_connections.svg)

The five layers of the Internet protocol stack are defined as follows:

- **Application**: The application layer is where end-user software resides. This could be any number of applications, for example a web server, a mail server, a web browser, or a P2P client. The HTTP protocol is commonly used at the application layer. Other protocols used at the application layer include the Simple Mail Transfer Protocol (SMTP), File Transfer Protocol (FTP), and the Domain Name System (DNS).
- **Transport**: The transport layer supports host-to-host communication. The Transmission Control Protocol (TCP) and User Datagram Protocol (UDP) are most commonly used. TCP is a reliable protocol and supports reliable data transmission, congestion control, and flow control. UDP is connectionless and unreliable. It may be used for applications such as voice over IP where it is better to ignore late-arriving packets rather than retransmit them.
- **Network**: The network layer is responsible for routing and addressing in the Internet. The Internet Protocol (IP) is used for this purpose. Routers maintain tables of IP addresses and the best routes to use to reach those addresses. When a packet arrives on one router interface, it uses these tables to determine which outgoing interface to choose.
- **Data Link/Media Access Control**: The link layer manages the connection between two networked devices. Depending on the media, it may be necessary to determine how multiple devices may share access to a single medium. Ethernet and Wireless Ethernet are examples of protocols used at this layer.
- **Physical**: The physical layer determines how bits are exchanged.