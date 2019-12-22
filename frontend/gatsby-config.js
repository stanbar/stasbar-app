module.exports = {
  plugins: [
    "gatsby-plugin-top-layout",
    "gatsby-plugin-typescript",
    "gatsby-plugin-material-ui",
    "gatsby-plugin-react-helmet",
    {
      resolve: `gatsby-plugin-google-analytics`,
      options: {
        // The property ID; the tracking code won't be generated without it
        trackingId: "UA-123888398-1"
      }
    }
  ],
  siteMetadata: {
    title: "stasbar"
  }
};
