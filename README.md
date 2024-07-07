Hay que tener en cuenta que esta es una aplicación en la que realmente no se está creando una sesión para el usuario.

Simplemente se tiene una clase que puede gestionar los usuarios que acceden a la lista de alumnos, y lo que hacemos es que cuando se crea un usuario se hace con el atributo "activo" en posición false, y cuando se accede, se cambia esa posición a True.
Pero en una aplicación real, esa instancia de usuario se asociaría con una sesión real, y solo tendríamos acceso a las diferentes páginas de la aplicación mientras la sesión se mantiene activa
