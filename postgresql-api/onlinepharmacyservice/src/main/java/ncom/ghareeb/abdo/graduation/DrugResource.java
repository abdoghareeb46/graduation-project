package ncom.ghareeb.abdo.graduation;


import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/drug")
@Produces(MediaType.APPLICATION_JSON)
public class DrugResource {
	DatabaseConnection dbc=new DatabaseConnection();
	@GET
    @Path("/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Result getDrug(@PathParam("drugName") String drugName ) throws SQLException{
		Result result = new Result(dbc.selectByDrugName(drugName));
		return result;
		
	}
}
