var feed = 'http://www.upeace.org';
var url = new java.net.URL(feed);
input = new java.util.Scanner(url.openStream());
input.useDelimiter('$')
var contents = input.next()
contents
