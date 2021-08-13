import com.challenge.model.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.challenge.postgres.QueryExecutor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class QueryExecutorTest {

    @InjectMocks
    private QueryExecutor queryExecutor;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPrepStatement;

    @Mock
    private ResultSet resultSetMock;


    @Test
    public void testGetClients() throws Exception {
        Mockito.when(mockConnection.prepareStatement(Mockito.any())).thenReturn(mockPrepStatement);

        Mockito.when(mockPrepStatement.executeQuery()).thenReturn(resultSetMock);
        Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSetMock.getString("cname")).thenReturn("Name");
        Mockito.when(resultSetMock.getString("cnif")).thenReturn("123456789");
        Mockito.when(resultSetMock.getString("caddress")).thenReturn("Address");
        Mockito.when(resultSetMock.getString("pn")).thenReturn("987654321");
        Mockito.when(resultSetMock.getInt("cid")).thenReturn(1);
        ArrayList<Client> value = queryExecutor.ExecuteGetClientsQuery();

        Assert.assertEquals(value.size(), 1);
    }

    @Test
    public void testGetClientsByNif() throws Exception {
        Mockito.when(mockConnection.prepareStatement(Mockito.any())).thenReturn(mockPrepStatement);

        Mockito.when(mockPrepStatement.executeQuery()).thenReturn(resultSetMock);
        Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSetMock.getString("cname")).thenReturn("Name");
        Mockito.when(resultSetMock.getString("cnif")).thenReturn("123456789");
        Mockito.when(resultSetMock.getString("caddress")).thenReturn("Address");
        Mockito.when(resultSetMock.getString("pn")).thenReturn("987654321");
        Mockito.when(resultSetMock.getInt("cid")).thenReturn(1);
        ArrayList<Client> value = queryExecutor.ExecuteGetClientByNif(123456789);
        Client clientValue = value.get(0);

        Assert.assertEquals(clientValue.getClient_nif(), 123456789);
        Assert.assertEquals(clientValue.getPhone_number(), 987654321);
        Assert.assertEquals(clientValue.getClient_name(), "Name");
        Assert.assertEquals(clientValue.getClient_address(), "Address");
        Assert.assertEquals(clientValue.getId(), 1);
    }

    @Test
    public void testGetClientsByName() throws Exception {
        Mockito.when(mockConnection.prepareStatement(Mockito.any())).thenReturn(mockPrepStatement);

        Mockito.when(mockPrepStatement.executeQuery()).thenReturn(resultSetMock);
        Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSetMock.getString("cname")).thenReturn("Name");
        Mockito.when(resultSetMock.getString("cnif")).thenReturn("123456789");
        Mockito.when(resultSetMock.getString("caddress")).thenReturn("Address");
        Mockito.when(resultSetMock.getString("pn")).thenReturn("987654321");
        Mockito.when(resultSetMock.getInt("cid")).thenReturn(1);
        ArrayList<Client> value = queryExecutor.ExecuteGetClientsByNameQuery("Name");

        Assert.assertEquals(value.size(), 1);
    }

    @Test
    public void testDeleteAndPost() throws Exception {

        Client c = new Client("a",123456789,"b",987654321);

        Mockito.when(mockConnection.prepareStatement(Mockito.any())).thenReturn(mockPrepStatement);

        Mockito.when(mockPrepStatement.executeUpdate()).thenReturn(1);

        queryExecutor.ExecuteDeleteQuery(1);

        queryExecutor.ExecuteInsertClientQuery("a",123456789,"b",987654321);

        Assert.assertEquals(c.getClient_nif(), 123456789);
        Assert.assertEquals(c.getPhone_number(), 987654321);
        Assert.assertEquals(c.getClient_name(), "a");
        Assert.assertEquals(c.getClient_address(), "b");

    }



}
