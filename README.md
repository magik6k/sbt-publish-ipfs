# SBT IPFS publishing plugin

This plugin creates new `publishIpfs` task that basically publishes tiny maven repo
to IPFS. To use this repo you have to add resolver to root hash of that tiny repo,
and then just add dependency as always.

**NOTE:** This plugin may override `publishTo` setting

## Use

### SBT:
`project/build.sbt`
```scala
resolvers += "ipfsPublish" at "https://ipfs.io/ipfs/QmRDoEHSQma4kaKLxd9YXF71FQvfBzSh8Rvdojc2UfThDu"
addSbtPlugin("eu.devtty" % "sbt-publish-ipfs" % "1.2.0")
```

`build.sbt`
```scala
enablePlugins(IpfsPublish)
```

## License

[MIT](LICENSE)
