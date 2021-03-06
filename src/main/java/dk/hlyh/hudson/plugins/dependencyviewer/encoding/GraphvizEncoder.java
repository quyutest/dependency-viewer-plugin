/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.hlyh.hudson.plugins.dependencyviewer.encoding;

import dk.hlyh.hudson.plugins.dependencyviewer.dependencies.GraphBuilder;
import dk.hlyh.hudson.plugins.dependencyviewer.util.DotRunner;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 *
 * @author henrik
 */
class GraphvizEncoder extends Encoder {

  private String imageType;
  private String dotType;

  GraphvizEncoder(GraphBuilder calculator, Locale currentLocale,String imageType, String dotType) {
    super(calculator,currentLocale);
    this.imageType = imageType;
    this.dotType = dotType;
  }

  public void encode(StaplerRequest req, StaplerResponse rsp) throws IOException {
    GraphvizFormatter executor = new GraphvizFormatter(currentLocale);
    String graphDot = executor.generateDotText(calculator.getCollectedNodes(), calculator.getCollectedLinks());    
    rsp.setContentType(imageType);
    DotRunner.runDot(rsp.getOutputStream(), new ByteArrayInputStream(graphDot.getBytes()), dotType);
  }
}
