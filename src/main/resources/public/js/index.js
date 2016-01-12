var NewsTable = React.createClass({
    getInitialState: function() {
        return {
            news: {fetching: true}
        };
    },
    componentDidMount: function() {
        $.get(this.props.source, function(result) {
            var json = JSON.parse(result);
            console.log(json);
            json.fetching = false;
            if(this.isMounted()) {
                this.setState({
                    news: json
                });
            }
        }.bind(this));
    },
    render: function() {
        var news = this.state.news;
        if(news.fetching) {
          return (
            <div>
             <h1>Fetching news</h1>
            </div>
          );
        } else {
          return (
             <div>
              <h1>News</h1>
              <p>Most popular: {news.popular}</p>
              <p>Latest: {news.latest}</p>
             </div>
          );
        }
    }
});

const API_SOURCE = 'http://localhost:4567/news';

ReactDOM.render(
    <NewsTable source={API_SOURCE} />,
    document.getElementById('container')
);
