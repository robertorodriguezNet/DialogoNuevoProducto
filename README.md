# DialogoNuevoProducto
App Android 2021.3.1

Formará parte del proyecto DAM
Es una aplicación de ejemplo, no hace nada.

Abre un diálogo para la inserción de un nuevo producto.

La clase DialogoNuevoProducto estiende Dialog y representa un cuadro de diálogo en cual se
muestra un formulario para cargar un nuevo producto.
El cuadro de diálogo tiene dos botones: "Agregar" y "Cancelar".

El evento sobre "Cancelar" se captura y procesa al declararse el botón.
El evento sobre "Agregar" se procesar en MianActivity.

Para asegurarnos de que MainActivity implemente la respuesta a la acción sobre "Agregar", se ha
creado la interfaz OnNuevoProductoListener, cuyo método onGuardarProductoClickListener debe ser
implementado por la clase que quiera responder, en este caso MainActivity.