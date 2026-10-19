package mathOperationsREST;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import jakarta.ws.rs.PathParam;

@Path("/MathOp")
public class WebMathResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String calculateHTMLOp(
            @QueryParam("x") double x,
            @QueryParam("y") double y,
            @QueryParam("z") double z) {

        MathOp op = new MathOp(x, y, z);

        return "<html><body>"
                + "<h2>Calculate (x+2*y+3*z) Output is: "
                + op.calculateSum() + "</h2>"
                + "<h2>Calculate (x*2*y*3*z) Output is: "
                + op.calculatePrd() + "</h2>"
                + "</body></html>";
    }
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public MathOp displayXYZJSON() {

        MathOp op = new MathOp(1, 2, 3);

        return op;
    }
    @GET
    @Path("/listArray")
    @Produces(MediaType.TEXT_HTML)
    public String displayListZYZ() {

        ArrayList<MathOp> listXYZ = new ArrayList<>();

        listXYZ.add(new MathOp(1, 2, 3));
        listXYZ.add(new MathOp(4, 5, 6));
        listXYZ.add(new MathOp(7, 8, 9));

        String output = "<html><body>";
        output += "<h2>listXYZ Array List:</h2>";

        for (MathOp op : listXYZ) {
            output += "<p>"
                    + "x = " + op.getX()
                    + ", y = " + op.getY()
                    + ", z = " + op.getZ()
                    + "</p>";
        }

        output += "</body></html>";

        return output;
    }
    @GET
    @Path("/OpHashMap/{x}")
    @Produces(MediaType.APPLICATION_JSON)
    public MathOp searchHashMapListZYZ(@PathParam("x") double x) {

        HashMap<Double, MathOp> opHashMap = new HashMap<>();

        opHashMap.put(1.0, new MathOp(1, 2, 3));
        opHashMap.put(4.0, new MathOp(4, 5, 6));
        opHashMap.put(7.0, new MathOp(7, 8, 9));

        return opHashMap.get(x);
    }
}