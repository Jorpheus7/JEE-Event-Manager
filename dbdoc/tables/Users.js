var graph = new joint.dia.Graph;

var paper = new joint.dia.Paper({
    el: $('#paper'),
    width: 800,
    height:600,
    gridSize: 1,
    model: graph
});
paper.scale(.75);
if(document.getElementById("zoom")) {
	document.getElementById("zoom").value=0.8;
}

/*var paperSmall = new joint.dia.Paper({
    el: $('#paper-small'),
    width: 250,
    height: 250,
    model: graph
});

paperSmall.scale(.2);
*/


paper.on('cell:pointerup', function(cellView , evt) {
	if(evt.ctrlKey) {
		
		//transforms TABLE_NAME in DToName ex: BOOK_ORDER becomes BookOrder
		var viewToFind = cellView.model.id.toLowerCase();
		var elem = viewToFind.split('_');
		viewToFind = "";

		for(var i= 0; i < elem.length; i++)
		{
			viewToFind = viewToFind	+ elem[i].charAt(0).toUpperCase() + elem[i].slice(1);
		}
		document.location.href="./"+viewToFind+".html";
	}   	
});


/*define positionning of different beans around central bean*/

var uml = joint.shapes.uml;
											
   var classes = {  
USERS: new uml.BDDTable({
		id:'USERS',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 83 },
        name: 'USERS',
        attributes: [
										'ID: INTEGER',
																								],
        methods: [
																	'MAIL: VARCHAR(255)',
														'PASSWD: VARCHAR(100)',
											]
    }),

	  
						
								EVENTS: new uml.BDDTable({
		id:'EVENTS',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 159 },
        name: 'EVENTS',
        attributes: [
										'ID: INTEGER',
																																																																		],
        methods: [
																	'NOM: VARCHAR(255)',
														'ADRESSE: VARCHAR(255)',
														'IDCREATEUR: INTEGER',
														'ACTIF: INTEGER',
														'DATEDEBUT: DATE',
														'HEUREDEBUT: TIME',
														'DATEFIN: DATE',
														'HEUREFIN: TIME',
									]
    }),
								};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
						new joint.dia.Link({
	source: { id: classes.EVENTS.id },
	target: { id: classes.USERS.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'SQL141027170947030' } }}
	]
}),	
								];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonUsersGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonUsersGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


