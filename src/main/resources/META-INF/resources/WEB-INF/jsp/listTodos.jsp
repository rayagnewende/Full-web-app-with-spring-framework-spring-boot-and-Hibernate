<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>Todos page</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
		         <div  class="col-md-2 col-md-2"><h1 class="">Todo liste</h1></div>
				<div class="col-md-8 col-md-8">
				    <table class="table">
			<thead>
			<tr>
			   <th>Nom</th>
			  <th>Description</th>
			   <th>Date</th>
			   	<th>Etat</th>
			</tr>
			</thead>
			<tbody>
			    <c:forEach items="${todos}" var="todo">
			    		<tr>
			   <td>${todo.username}</td>
			  <td>${todo.description}</td>
			   <td>${todo.targetDate }</td>
			   	<td>${todo.done}</td>
			</tr>
			    </c:forEach>
			</tbody>
		
	</table>
				</div>
	<div  class="col-md-2 col-md-2"></div>
				
		</div>

     <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>