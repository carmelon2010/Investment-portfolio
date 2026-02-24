import com.massive.kotlin.sdk.rest.*;

public class ApiHandler {
    public static void main(String[] args) throws InterruptedException {
    MassiveRestClient client = new MassiveRestClient(massiveKey);

    AggregatesDTO aggs = client.getAggregatesBlocking(
      new AggregatesParametersBuilder()
        .ticker("AAPL")
        .timespan("day")
        .fromDate("2023-02-01")
        .toDate("2023-04-01")
        .build()
    );

    System.out.println("Got " + aggs.getResults().size() + " results");
  }
}
