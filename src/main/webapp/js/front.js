


let content_dict = {
		search: "<div> search </div>",
		addFlight: "<div> add </div>",
		cancelFlight: "<div> cancel </div>",
		requestFlight: "<div> request </div>",
		recentChanges: "<div> recent </div>",

		}

/*
let render = (content, node) => {
	node.innerHTML = content;
}
*/


let populateContent = (content_type) => {
	console.log(content_type);
	let content = content_dict[content_type];
	console.log(content);
	document.getElementById('content').innerHTML = content;
	
}
