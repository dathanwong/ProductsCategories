<!doctype html>
<html lang="en">
    <head>
        <title>Product Page</title>
        <!-- Required meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <div class="row my-2">
                        <h1><c:out value="${product.name}"></c:out></h1>
                    </div>
                    <div class="row my-2">
                        <h2 class="col-6">Categories:</h2>
                    </div>
                    <div class="row my-2">
                        <ul>
                        	<c:forEach items="${product.categories}" var="category">
                            	<li><c:out value="${category.name}"></c:out></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-6">
                	<form action="/product/${product.id}/category/add" method="post">
	                    <div class="row my-2">
	                        <div class="col-6">Add Category:</div>
	                        <select name="category" name="category" id="category">
	                        	<c:forEach items="${categories}" var="category">
	                            	<option value="${category.id}"><c:out value="${category.name}"></c:out></option>
	                            </c:forEach>
	                        </select>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <button type="submit" class="btn btn-primary">Add</button>
	                        </div>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>