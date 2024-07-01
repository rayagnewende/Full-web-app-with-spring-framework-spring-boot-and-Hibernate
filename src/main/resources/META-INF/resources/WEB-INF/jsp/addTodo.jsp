<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>Page d'ajout d'une tache </title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	      <div class="container">
	             <h1 class="text-center my-5">Ajouter une tache</h1>
	             <div  class="row">
	               <div class="col-md-3"></div>
	                <div class='col-md-6 col-lg-6 '>
	                   <form:form action="add-todo" method="POST" modelAttribute="todo">
	                         <form:input type="hidden" path="username" class="form-control" />
	                          <div class="form-group">
	                         <label>Description</label>
	                         <form:input type="text" path="description" required="required"  class="form-control" />
	                         <form:errors   path="description"  cssClass="text-warning"/>
	                        </div>
	                        
	                        <form:input type="hidden" path="id" required="required"  class="form-control" />
	                         <form:input type="hidden" path="done" required="required"  class="form-control" />
	                         <input type="submit" value="Valider"  name="submit" class="btn btn-success" >
	                   </form:form>
	                </div>
	                <div class="col-md-3"></div>
	             </div>
	              
	      </div>
	</body>
</html>