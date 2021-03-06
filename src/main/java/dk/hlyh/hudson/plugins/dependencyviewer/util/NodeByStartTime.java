/*
 * Copyright (c) 2011 Henrik Lynggaard
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dk.hlyh.hudson.plugins.dependencyviewer.util;

import dk.hlyh.hudson.plugins.dependencyviewer.dependencies.Node;
import java.util.Comparator;
import java.util.Date;

public class NodeByStartTime implements  Comparator<Node> {

  public int compare(Node o1, Node o2) {
    
    Date o1Time = o1.getBuildStart();
    Date o2Time = o2.getBuildStart();
    if (o1Time == null && o2Time == null) {
      return  0;
    }
    if (o1Time == null) {
      return 1;
    }
    if (o2Time == null) {
      return -1;
    }
    return o1Time.compareTo(o2Time);
  }
}
