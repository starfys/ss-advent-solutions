library(igraph)
library(TSP)
library(combinat)
library(xtable)

setwd("~/Projects/advent-io/day09")
intermediate=read.csv("Riuchando.input", sep = " ",header = F)
intermediate$V2=NULL
intermediate$V4=NULL
intermediate$V1=as.character(intermediate$V1)
intermediate$V3=as.character(intermediate$V3)
intermediate$weights=intermediate$V5
intermediate$V5=NULL
graph=graph.data.frame(intermediate,directed = F)
plot(graph)
#list.edge.attributes(graph)
#get.edge.attribute(graph, "weights")
#V(graph)
#shortest.paths(graph, v=V(graph), to= V(graph), weights = get.edge.attribute(graph, "weights"))
#install.packages("TSP")


intermediate
my_dist=matrix(rep(Inf, 49), nrow= 7)
