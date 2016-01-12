var NewsTable = React.createClass({
    getInitialState: function() {
        return {
            news: 'Fetching news'
        };
    },
    componentDidMount: function() {
        $.get(this.props.source, function(result) {
            if(this.isMounted()) {
                this.setState({
                    news: result
                });
            }
        }.bind(this));
    },
    render: function() {
        var news = this.state.news;
        return (
           <div>
            <h1>News</h1>
            <p>{news}</p>
           </div>
        );
    }
});

const API_SOURCE = 'http://localhost:4567/news';

ReactDOM.render(
    <NewsTable source={API_SOURCE} />,
    document.getElementById('container')
);
