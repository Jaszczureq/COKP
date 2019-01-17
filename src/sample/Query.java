package sample;

public class Query {
    private Card card_in_query;
    private String currency;
    private String firm;
    private float amount;

    public Query(Card card_in_query, String currency, String firm, float amount) {
        this.card_in_query = card_in_query;
        this.currency = currency;
        this.firm=firm;
        this.amount=amount;
    }

    public Query(Query query) {
        this.card_in_query = query.card_in_query;
        this.currency = query.currency;
    }

    @Override
    public String toString() {
        return "Query{" +
                "card_in_query=" + card_in_query +
                ", currency='" + currency + '\'' +
                ", firm='" + firm + '\'' +
                ", amount=" + amount +
                '}';
    }
}
