from weaviate import Client

import weaviate
import json
import sys

def initializeClient(weaviateUrl: str) -> Client:
    return Client(weaviateUrl)


def createSchemas(client: Client, schemaPath: str):
    with open(schemaPath, "r") as schemaFile:
        schemaClasses = json.load(schemaFile)
        schemaClassNames = (schemaClass["class"] for schemaClass in schemaClasses["classes"])
        schemas = client.schema.get()
        existingSchemaClassNames = (schemaClass["class"] for schemaClass in schemas["classes"])

        duplicateExists = False

        for existingClass in schemas["classes"]:
            for classToCreate in schemaClasses["classes"]:
                if existingClass["class"] == classToCreate["class"]:
                    duplicateExists = True
                    break

    if schemas["classes"] is not None and not duplicateExists:
        print("Creating", ",".join(schemaClassNames), "schema(s)")
        client.schema.create(schemaPath)
    else:
        print("Trying to create classes:", ",".join(schemaClassNames))
        print("These classes already exist:", ",".join(existingSchemaClassNames))
        print("Skipped creating any new schema")


try:
    weaviateServerAddress = sys.argv[1].strip()
except IndexError:
    weaviateServerAddress = None

try:
    weaviateSchema = sys.argv[2].strip()
except IndexError:
    weaviateSchema = None



if weaviateServerAddress is None or weaviateServerAddress == "" or weaviateSchema is None or weaviateSchema == "":
    print("Missing argument. Usage:")
    print("python3 weaviate-setup.py <WEAVIATE_SERVER_URL> <PATH/TO/SCHEMA>")
    exit(0)


print(f"Using weaviate server: {weaviateServerAddress}")
print(f"Using weaviate schema from: {weaviateSchema}")

client = initializeClient(weaviateUrl = weaviateServerAddress)

createSchemas(client, schemaPath = weaviateSchema)

