

window.onload = () => {
	document.getElementById('user').innerHTML = sessionStorage.getItem('username');
}


let content_dict = {
		search: "<div>" +
					"<div> <br/>" +
						"Flight #: <input type='search'/> <button> Search </button> <br/>" +
						"Time: <input /> : <input/> to <input/> : <input/> <br/>" +
						"Date: <input type='date' /> <br/>" +
						"Airline: <input/> <br/>" +
						"<button> Departure </button> <button> Arrival </button> <br/>" +
					"</div>" +
				"</div>",
				
		addFlight: "<div>" +
					"<div> <br/>" + 
						"Time: <input /> : <input/> to <input/> : <input/> <br/>" +
						"Date: <input type='date' /> <br/>" +
						"<button> Departure </button> <button> Arrival </button> <br/>" +
						"Departure Location: <input/> <br/>" +
						"Arrival Location: <input/> <br/>" +
						"Priority <input type='checkbox'/> <br/>" + 
					"</div>" +
				"</div>",
				
		cancelFlight: "<div>" +
					"<div> <br/>" +
						"Flight #: <input type='search'/> <button> Search </button> <br/>" +
						"Time: <input /> : <input/> to <input/> : <input/> <br/>" +
						"Date: <input type='date' /> <br/>" +
						"<div>" +
							"<h3> List of Flights </h3>" +
							"<div id='cancel_list'> </div>" +
						"</div>" +
					"</div>" +
				" </div>",
		requestFlight: "<div>" +
					"<div> <br/>" +
								"Flight #: <input type='search'/> + " +
								"<button> Search </button> <br/>" +
								"Time: <input /> : <input/> to <input/> : <input/> <br/>" +
								"Date: <input type='date' /> <br/>" +
								"<div>" +
								"<h3> List of Flights </h3>" +
								"<div id='request_list'> </div>" +
							"</div>" +
					"</div> " +
				" </div>",
		recentChanges: "<div id='recent_list'>  </div>",

		}

let populateContent = (content_type) => {
	console.log(content_type);
	let content = content_dict[content_type];
	console.log(content);
	document.getElementById('content').innerHTML = content;
}

let logout = () => {
	//also need to make call to db to sign out
	location.href = "http://localhost:8080/FlightScheduler_FrontEnd/login";
}
