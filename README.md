# entitymanagementsystem
Entity Management using REST api

This is a sample REST based entity management system.
Already very good implementation of similar systems exist in open source, this is just for learning purpose.

Capabilities (planned, very few thing are working present):
1. This entity management systems allows free nesting of different types and sub types.
2. Entity definitions can be created for validation purpose.
3. Attribute values are stored as part of the entity.
4. Attribute values are stored as String. But using attribute definition different conversion can be done.
5. Attribute values also have rendering information.
6. Subentities are stored as independent entities and a refence to those are stored in the entity using the name of substities.
7. The names of entities and subentities are like ids and should be unique to be referred further.
8. Attribute names must be unique within the entity as attributes are not shared.
9. Attribute names, Entity names and Subentity names are different from their definitions.

Current Status:
The over all application framework is ready.
REST end points for add and get of entitytypes are working fine.
For the remaining the code is there and tested with junit.
Only the REST endpoint to service call has to be coded.
It is in very half baked state to be treated as an enterprise application and is just for view purpose.

To execute run the following comands:
1. Build : mvn clean install
2. Run : java -jar target/ems.jar
