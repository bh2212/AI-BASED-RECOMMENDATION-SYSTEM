# AI-BASED-RECOMMENDATION-SYSTEM

COMPANY: CODTECH IT SOLUTIONS

NAME: BHUVANESHWARI.K

INTERN ID: CT12LUW

DOMAIN: JAVA PROGRAMMING

DURATION: 8 WEEKS

MENTOR: NEELA SANTOSH

## DESCRIPTION OF TASK: The AI based recommendation system task has been successfully runned in the eclipse software platform.

## Explanation:

1. Import necessary libraries:

Import Mahout classes for data modeling, similarity calculations, and recommendation generation.

2. Load the data model:

Load the user preferences from the CSV file into a FileDataModel.

3. Build the user-based recommender:

Use PearsonCorrelationSimilarity to compute similarities between users.

Define a user neighborhood using NearestNUserNeighborhood.

Create a GenericUserBasedRecommender using the data model, neighborhood, and user similarity.

4. Get user-based recommendations:

Get recommendations for a specific user (userID = 1 in this case).

Print the recommended items.

5. Build the item-based recommender:

Use PearsonCorrelationSimilarity to compute similarities between items.

Create a GenericItemBasedRecommender using the data model and item similarity.

6. Get item-based recommendations:

Get recommendations for items similar to a specific item (itemID = 101 in this case).

Print the recommended items.

## Running the Program in Eclipse:

Create a new Java project in Eclipse. 

Add the required Mahout dependencies to your project (either manually or using Maven).

Create a new Java class file named RecommendationEngine.

Create a CSV file named preferences.csv with the sample data and place it in the root directory of your project.

Run the RecommendationEngine class as a Java application.

## Output:

User-based recommendations for user 1:

RecommendedItem[itemID:104, value:3.5]

RecommendedItem[itemID:105, value:3.0]

RecommendedItem[itemID:106, value:2.5]

Item-based recommendations for item 101:

RecommendedItem[itemID:103, value:2.0]

RecommendedItem[itemID:104, value:1.5]

RecommendedItem[itemID:105, value:1.0]

 
This AI based recommendation system task demonstrates a simple way to create a recommendation system using Java and Apache Mahout. 
