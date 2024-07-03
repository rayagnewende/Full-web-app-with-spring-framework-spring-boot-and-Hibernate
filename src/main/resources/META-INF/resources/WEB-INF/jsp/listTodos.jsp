         <%@ include file="common/header.jsp" %>
	     <%@ include file="common/navigation.jsp" %>
		<div class="container">
		  <h1 class="text-center my-5">Liste des taches</h1>
		        <div class="row">
		        			 <div  class="col-md-2 col-md-3"></div>
				<div class="col-md-8 col-md-6">
				    <table class="table">
			<thead>
			<tr>
			  <th>Description</th>
			   <th>Date</th>
			   	<th>Etat</th>
			   	<th></th>
			   	<th></th>
			</tr>
			</thead>
			<tbody>
			    <c:forEach items="${todos}" var="todo">
			    <tr>
			  <td>${todo.description}</td>
			   <td>${todo.targetDate }</td>
			   	<td>${todo.done}</td>
			   	<td><a class="btn btn-warning" href="update-todo?id=${todo.id }">UPDATE</a></td>
			     <td><a class="btn btn-danger" href="delete-todo?id=${todo.id }">SUPPRIMER  ${todo.id }</a></td>
			   	
			</tr>
			    </c:forEach>
			</tbody>
		
	</table>
	<a href="add-todo" class="btn btn-success">Ajouter une tache</a>
	</div>
	<div  class="col-md-2 col-md-3"></div>
				
		        </div>
		</div>

     <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>