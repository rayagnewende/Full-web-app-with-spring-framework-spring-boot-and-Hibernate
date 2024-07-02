<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>Page d'ajout d'une tache </title>
	      <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"  rel="stylesheet">
	    <link  href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
	    
	</head>
	<body>
	      <div class="container">
	             <h1 class="text-center my-5">Ajouter une tache</h1>
	             <div  class="row">
	               <div class="col-md-3"></div>
	                <div class='col-md-6 col-lg-6 '>
	                   <form:form action="add-todo" method="POST" modelAttribute="todo">
	                         <div class="form-group">
	                         <label>Description</label>
	                         <form:input type="text" path="description" required="required"  class="form-control" id="datepicker" />
	                         <form:errors   path="description"  cssClass="text-warning"/>
	                        </div>
	                        
	                         <div class="form-group">
	                         <label>Description</label>
	                         <form:input type="text" path="targetDate" required="required"  class="form-control" id="datepicker" />
	                         <form:errors   path="targetDate"  cssClass="text-warning"/>
	                        </div>
	                        
	                        <form:input type="hidden" path="id" required="required"  class="form-control" />
	                         <form:input type="hidden" path="done" required="required"  class="form-control" />
	                         <input type="submit" value="Valider"  name="submit" class="btn btn-success" >
	                   </form:form>
	                </div>
	                <div class="col-md-3"></div>
	             </div>
	              
	      </div>	   
	      <script  src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script> 
	      <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	      <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	      <script   type="text/javascript" >
	      $('#datepicker').datepicker({
	    	    format: 'yyyy-mm-dd',
	   
	    	});
	      </script>
	</body>
</html>