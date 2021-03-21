# PALab5

* Compulsory
	* Create an object-oriented model of the problem. You should have at least the following classes: Catalog and two item classes at your choice. Consider using an interface or an abstract class in order to describe the items in a catalog.
	* Implement the following methods representing commands that will manage the content of the catalog:
		* add: adds a new entry into the catalog;
		* list: prints the content of the catalog on the screen;
		* play: playback using the native operating system application (see the Desktop class);
		* save: saves the catalog to an external file (either as a text or binary, using object serialization);
		* load: loads the catalog from an external file.
	* The application will signal invalid data (year, path, etc.) using a custom exception.
* Optional
	* Create a shell that allows reading commands from the keyboard, together with their arguments.
	* Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command.
	* Implement the commands add, list, save, load, play (create the classes AddCommand, ListCommand, etc.).
	* Implement the command report: create (and open) an HTML report representing the content of the catalog.
	* Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.
	* The application will signal the commands that are not valid using a custom exception.