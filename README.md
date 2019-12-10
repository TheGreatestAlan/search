Search

This is a basic search caching application.  It's designed to be implemented with a standard relational database, interfacing with that in the SearchPersister class.  The implementation of the query service also needs to happen in the QueryService class.  All the controllers use interfaces to easily swap out implementations of the various components, ease unit testing, and all the other reasons for dependency inversion.  The API consists of 2 controllers:

Find controller "/find":  Handles the actual querying.  1 method, post, takes a SearchDTO json that was specified in the requirements.  Upon post saves and search and returns search results in SearchResponseDTO format.  

Search controller "/search": Handles the management of the searches.  3 methods: 
	get to /search/{clientid}
		retrieves all searches for client
		returns an array of SearchDTO objects
	get to /search/{clientid}/{keyword}
		retrieves all searches for keyword within client
		returns an array of SearchDTO objects
	delete to /search
		deletes specified searches.  Must contain SearchId retrieved from gets at the same endpoint.  Takes an array of SearchDTO objects
		returns a no_content response
Scaling:
	I would scale this with multiple instances of the server up behind a load balancer.  If load increased to a sufficient amount I would spin up more instances of the server to meet demand. Alternatively I toyed with the idea of having the client make an asyncronous call to the search server, then poll a resultsendpoint so we wouldn't have to worry about timing out, but there wasn't a lot of detail given on how quickly the queryservice returned.  If the query service returns quickly, then it's alright to have the implementation I have, if it's slowly then we could shift over that way.    

Metrics and Activity Log:
	Since the database stores the Client id, a record of all the searches made by a client can be queried from the database.  Additionally metrics can also be queried from the database as well.
