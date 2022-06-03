console.log("hola que mas ps");

/*
$(document).ready(function(){
	
	$('#guardar').click(function(event){
		
 		var nombre= $('#nombre').val();
		var apellido= $('#apellido').val();
		
  		$.post('NewServlet',{nombre:nombre,apellido:apellido,boton:'guardar'},function(responseText){
      
      		$('#tabla').html(responseText);
      		
        }); 
          
	});
 
 	$('#modificar').click(function(event){
	
 		var nombre= $('#nombre').val();
		var apellido= $('#apellido').val();
		
  		$.post('NewServlet',{nombre:nombre,apellido:apellido,boton:'modificar'},function(responseText){
      
			$('#tabla').html(responseText);
			
        }); 
          
 	});

});
*/

$(document).ready(() => {
	
	console.log("se cargo la pagina");
	
	$("#entrada").keyup((event) => {
		
		var busqueda = $("#entrada").val();
		
		//console.log("se presiono una tecla");
		//console.log(busqueda);
		
		$.post("controlprincipal", {busqueda:busqueda,entrada:"documento"}, (responseText) => {
			
			console.log(responseText);
			
			//$("#salida").html(responseText);
			
		});
				
	});
	
	
	
});











