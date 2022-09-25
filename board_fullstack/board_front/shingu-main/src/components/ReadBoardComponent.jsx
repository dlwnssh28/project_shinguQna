import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class ReadBoardComponent extends Component {
    constructor(props) {
        super(props);

        this.state = { 
            no: this.props.match.params.no,
            board: {}
        }

        this.goToUpdate = this.goToUpdate.bind(this);


    }

    componentDidMount() {
        BoardService.getOneBoard(this.state.no).then( res => {
            this.setState({board: res.data});
            console.log("get result => "+ JSON.stringify(res.data));
        });
    }

    

    // returnBoardType(typeNo) {
    //     let type = null;
    //     if (typeNo == 1) {
    //         type = "자유게시판";

    //     } else if (typeNo == 2 ) {
    //         type = "질문과 답변 게시판";

    //     } else {
    //         type = "타입 미지정";
    //     }

    //     return (
    //         <div className = "row">
    //             <label> Board Type : </label> {type}
    //         </div>
    //     )

    // }

    returnDate(cTime, uTime) {
        return (
            <div className = "row">
                <label>생성일 : [ {cTime} ] / 최종 수정일 : [ {uTime} ] </label>
            </div>
        )
    }


    goToList() {
        this.props.history.push('/board');
        window.location.reload();
    }

    goToUpdate = (event) => {
        event.preventDefault();
        this.props.history.push(`/create-board/${this.state.no}`);
        window.location.reload();
    }

    deleteView = async function () {
        if(window.confirm("정말로 글을 삭제하시겠습니까?\n삭제된 글은 복구 할 수 없습니다.")) {
            BoardService.deleteBoard(this.state.no).then( res => {
                console.log("delete result => "+ JSON.stringify(res));
                if (res.status == 200) {
                    this.props.history.push('/board');
                    window.location.reload();
                } else {
                    alert("글 삭제가 실패했습니다.");
                    window.location.reload();
                }
            });

        }
    }


    render() {
        return (
            <div>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className ="text-center"> Read Detail</h3>
                    <div className = "card-body">
                            <div className = "row">      
                                {this.state.board.division} {this.state.board.department}
                            </div>

                            <br></br>

                            <div className = "row">      
                                 제목  : {this.state.board.title}
                            </div>

                            <br></br>

                            <div className = "row">
                                <label>질문 </label>  <br></br>
                                <textarea value={this.state.board.contents} readOnly/> 
                            </div >

                            <br></br>

                            <div className = "row">
                                <label> 답변  </label>  <br></br>
                                <textarea value={this.state.board.answercontents} readOnly/> 
                            </div>

                            <br></br>

                            <button className="btn btn-primary" onClick={this.goToList.bind(this)} style={{marginLeft:"10px"}}>목록으로 </button>
                            <button className="btn btn-info" onClick={this.goToUpdate} style={{marginLeft:"10px"}}>글 수정</button>
                            <button className="btn btn-danger" onClick={() => this.deleteView()} style={{marginLeft:"10px"}}>글 삭제</button>


                    </div>
                </div>

            </div>
        );
    }
}

export default ReadBoardComponent;