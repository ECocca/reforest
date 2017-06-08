/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package reforest.dataTree;

import org.junit.Assert;
import org.junit.Test;
import reforest.test.BroadcastSimple;
import scala.Option;
import scala.collection.mutable.ListBuffer;

import static junit.framework.Assert.assertTrue;

public class TreeTest {
    private final Tree<Double, Integer> tree = new Tree(10);

    @Test
    public void getNodeToBeComputed() {
        ListBuffer<Object> list = tree.getNodeToBeComputed();

        Assert.assertEquals(1, list.size());
        Assert.assertEquals("only root must be computed",0, list.apply(0));
    }

    @Test
    public void getLevel() {
        Assert.assertEquals(0, tree.getLevel(0));
        Assert.assertEquals(1, tree.getLevel(1));
        Assert.assertEquals(1, tree.getLevel(2));
        Assert.assertEquals(2, tree.getLevel(3));
        Assert.assertEquals(2, tree.getLevel(4));
        Assert.assertEquals(2, tree.getLevel(5));
        Assert.assertEquals(2, tree.getLevel(6));
        Assert.assertEquals(3, tree.getLevel(7));
    }

    @Test
    public void getLeftChild() {
        Assert.assertEquals(1, tree.getLeftChild(0));
        Assert.assertEquals(3, tree.getLeftChild(1));
        Assert.assertEquals(5, tree.getLeftChild(2));
        Assert.assertEquals(7, tree.getLeftChild(3));
        Assert.assertEquals(9, tree.getLeftChild(4));
        Assert.assertEquals(11, tree.getLeftChild(5));
    }

    @Test
    public void getRightChild() {
        Assert.assertEquals(2, tree.getRightChild(0));
        Assert.assertEquals(4, tree.getRightChild(1));
        Assert.assertEquals(6, tree.getRightChild(2));
        Assert.assertEquals(8, tree.getRightChild(3));
        Assert.assertEquals(10, tree.getRightChild(4));
        Assert.assertEquals(12, tree.getRightChild(5));
    }

    @Test
    public void getParent() {
        Assert.assertEquals(0, tree.getParent(0));
        Assert.assertEquals(0, tree.getParent(1));
        Assert.assertEquals(0, tree.getParent(2));
        Assert.assertEquals(1, tree.getParent(3));
        Assert.assertEquals(1, tree.getParent(4));
        Assert.assertEquals(2, tree.getParent(5));
    }

    @Test
    public void setIsLeaf() {
        Assert.assertEquals(false, tree.isLeaf(0));
        Assert.assertEquals(false, tree.isLeaf(1));
        Assert.assertEquals(false, tree.isLeaf(2));
        tree.setLeaf(1);
        Assert.assertEquals(false, tree.isLeaf(0));
        Assert.assertEquals(true, tree.isLeaf(1));
        Assert.assertEquals(false, tree.isLeaf(2));
    }

}
