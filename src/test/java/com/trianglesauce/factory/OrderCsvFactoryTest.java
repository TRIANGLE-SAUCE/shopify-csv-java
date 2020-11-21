package com.trianglesauce.factory;

import com.trianglesauce.dto.OrderCsv;
import com.trianglesauce.dto.OrderCsvBuilder;
import com.trianglesauce.enums.BuyerAcceptsMarketing;
import com.trianglesauce.enums.FinancialStatus;
import com.trianglesauce.enums.FulfillmentStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;

class OrderCsvFactoryTest {

    private final CsvFactory<OrderCsv> factory = new OrderCsvFactory();

    private static final ZoneId JST_ZONE_ID = ZoneId.of("JST", ZoneId.SHORT_IDS);

    @Test
    void createCsv() throws Exception {
        OrderCsv orderCsv = new OrderCsvBuilder()
                .withName("John")
                .withEmail("test@triangle-sauce.com")
                .withFinancialStatus(FinancialStatus.PAID)
                .withFulfillmentStatus(FulfillmentStatus.FULFILLED)
                .withCurrency("JPY")
                .withBuyerAcceptsMarketing(BuyerAcceptsMarketing.TURE)
                .withNote("Review verified, discount code e-mailed")
                .withPhone("555-5555")
                .withReferringSite(new URL("https://triangle-sauce.com"))
                .withProcessedAt(ZonedDateTime.of(LocalDate.of(2020, 11, 1), LocalTime.MIN, JST_ZONE_ID))
                .withShippingName("Taro Tanaka")
                .withShippingPhone("50055556565")
                .withShippingFirstName("Taro")
                .withShippingLastName("Tanaka")
                .withShippingCountry("Japan")
                .withShippingCountyCode("JP")
                .withLineitemName("Mini Handle Shovel")
                .build();
        String expected = "Name,Email,\"Financial Status\",\"Fullfillment Status\",Currency,\"Buyer Accepts Marketing\",\"Cancel Reason\",\"Cancelled At\",Tags,Note,Phone,\"Referring Site\",\"Processed At\",\"Source name\",\"Total weight\",\"Total Tax\",\"Shipping Company\",\"Shipping Name\",\"Shipping Phone\",\"Shipping First Name\",\"Shpiping Last Name\",\"Shipping Address1\",\"Shipping Address2\",\"Shipping City\",\"Shipping Province\",\"Shipping Province Code\",\"Shipping Zip\",\"Shipping Country\",\"Shipping Country Code\",\"Billing Company\",\"Billing Name\",\"Billing Phone\",\"Billing First Name\",\"Billing Last Name\",\"Billing Address1\",\"Billing Address2\",\"Billing City\",\"Billing Province\",\"Billing Province Code\",\"Billing Zip\",\"Billing Country\",\"Billing Country Code\",\"Lineitem name\",\"Lineitem variant id\",\"Lineitem quantity\",\"Lineitem price\",\"Lineitem variant title\",\"Lineitem compare at price\",\"Lineitem sku\",\"Lineitem requires shipping\",\"Lineitem taxable\",\"Lineitem fullfillment status\",\"Taxes Included\",\"Tax 1 Title\",\"Tax 1 Price\",\"Tax 1 Rate\",\"Tax 2 Title\",\"Tax 2 Price\",\"Tax 3 Rate\",\"Tax 3 Title\",\"Tax 3 Price\",\"Transaction Amount\",\"Transaction Kind\",\"Transaction Status\",\"Transaction Processed At\",\"Transaction Gateway\",\"Transaction Localtion Id\",\"Transaction Source Name\",\"Shipping Line Code\",\"Shipping Line Price\",\"Shipping Line Source\",\"Shipping Line Title\",\"Shipping Line Carrier Identifier\",\"Shipping Line Requested Fullfillment Service Id\",\"Shipping Tax 1 Title\",\"Shipping Tax 1 Rate\",\"Discount Code\",\"Discount Amount\",\"Discount Type\",\"Metafield Namespace\",\"Metafield Key\",\"Metafield Value\",\"Metafield Value Type\",\"Shipping Tax Price\",\"Tax 2 Rate\"\n" +
        "John,test@triangle-sauce.com,paid,fulfilled,JPY,TURE,,,,\"Review verified, discount code e-mailed\",555-5555,\"https://triangle-sauce.com\",\"2020-11-01T00:00:00+09:00\",,,,,\"Taro Tanaka\",50055556565,Taro,Tanaka,,,,,,,Japan,JP,,,,,,,,,,,,,,\"Mini Handle Shovel\",,,,,,,,,,false,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\n";
        Assertions.assertThat(factory.create(Collections.singletonList(orderCsv)))
                .isEqualTo(expected);
    }

}
