# entitymanagementsystem
Entity Management using REST api

This is a REST based entity management system

Capabilities:
1. This entity management systems allows free nesting of different types and sub types.
2. Entity definitions can be created for validation purpose.
3. Attribute values are stored as part of the entity.
4. Attribute values are stored as String. But using attribute definition different conversion can be done.
5. Attribute values also have rendering information.
6. Subentities are stored as independent entities and a refence to those are stored in the entity using the name of substities.
7. The names of entities and subentities are like ids and should be unique to be referred further.
8. Attribute names must be unique within the entity as attributes are not shared.
9. Attribute names, Entity names and Subentity names are different from their definitions.