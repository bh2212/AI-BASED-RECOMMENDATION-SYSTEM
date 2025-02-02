import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator.Stats;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecommendationEngine {

    public static void main(String[] args) {
        try {
            // Load the data model from the CSV file
            DataModel model = new FileDataModel(new File("preferences.csv"));

            // Build the user-based recommender
            UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, userSimilarity, model);
            GenericUserBasedRecommender userRecommender = new GenericUserBasedRecommender(model, neighborhood, userSimilarity);

            // Get recommendations for a user
            long userID = 1;
            List<RecommendedItem> userRecommendations = userRecommender.recommend(userID, 3);
            System.out.println("User-based recommendations for user " + userID + ":");
            for (RecommendedItem recommendation : userRecommendations) {
                System.out.println(recommendation);
            }

            // Build the item-based recommender
            ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(model);
            GenericItemBasedRecommender itemRecommender = new GenericItemBasedRecommender(model, itemSimilarity);

            // Get recommendations for an item
            long itemID = 101;
            List<RecommendedItem> itemRecommendations = itemRecommender.recommendedBecause(userID, itemID, 3);
            System.out.println("Item-based recommendations for item " + itemID + ":");
            for (RecommendedItem recommendation : itemRecommendations) {
                System.out.println(recommendation);
            }

        } catch (IOException | TasteException e) {
            e.printStackTrace();
        }
    }
}
