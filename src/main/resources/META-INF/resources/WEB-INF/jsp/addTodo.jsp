                  <%@ include file="common/header.jsp" %>
	      	     <%@ include file="common/navigation.jsp" %>
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
	 <%@ include file="common/footer.jsp" %>
	  