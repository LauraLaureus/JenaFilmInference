package jenafilminference;

import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.PrintUtil;
import org.apache.jena.vocabulary.RDF;

/**
 *
 * @author lala
 */
public class JenaFilmInference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ns = "urn:si2:films:";
        
        LogCtl.setCmdLogging();
        
        Model scheme = RDFDataMgr.loadModel("scheme.ttl");
        Model data = RDFDataMgr.loadModel("data.ttl");
        
        //Reasoner reasoner = ReasonerRegistry.getRDFSSimpleReasoner();
        //InfModel inference = ModelFactory.createInfModel(reasoner, scheme,data);
        InfModel inference = ModelFactory.createRDFSModel(scheme, data);
        
        StmtIterator iter;
        Resource jackson = inference.getResource(ns+"Jackson");
        iter = inference.listStatements(jackson,null ,(RDFNode)null);
        System.out.println("--------------Jackson---------------");
        while(iter.hasNext()){
            Statement statement = iter.nextStatement();
            System.out.println("--->" + PrintUtil.print(statement));
        }
        
        Resource hobbit = inference.getResource(ns+"hobbit");
        iter = inference.listStatements(hobbit, null,(RDFNode)null);
        System.out.println("--------------HOBBIT---------------");
        while(iter.hasNext()){
            Statement statement = iter.nextStatement();
            System.out.println("--->" + PrintUtil.print(statement));
        }
        
        Resource freeman = inference.getResource(ns+"freeman");
        iter = inference.listStatements(freeman, null,(RDFNode)null);
        System.out.println("--------------FREEMAN---------------");
        while(iter.hasNext()){
            Statement statement = iter.nextStatement();
            System.out.println("--->" + PrintUtil.print(statement));
        }
        
        Resource mckellan = inference.getResource(ns+"mckellan");
        iter = inference.listStatements(mckellan, null,(RDFNode)null);
        System.out.println("--------------MCKELLAN---------------");
        while(iter.hasNext()){
            Statement statement = iter.nextStatement();
            System.out.println("--->" + PrintUtil.print(statement));
        }
        
        
    }
    
}
