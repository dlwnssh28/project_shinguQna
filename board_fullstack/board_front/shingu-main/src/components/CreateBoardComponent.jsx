import React, { Component } from 'react';
import BoardService from '../service/BoardService.js';

class CreateBoardComponent extends Component {
    constructor(props) {
        super(props);


        this.state = {
            no: this.props.match.params.no,      
            division: '',
            department: '',
            answercontents:'',
            category: '',
            title: '',
            contents: '',
            studentid: ''
        }


        this.changeDivisionHandler = this.changeDivisionHandler.bind(this);
        this.changeDepartmentHandler = this.changeDepartmentHandler.bind(this);
        this.changeCategoryHandler = this.changeCategoryHandler.bind(this);
        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeContentsHandler = this.changeContentsHandler.bind(this);
        this.changeStudentidHandler = this.changeStudentidHandler.bind(this);
        this.createBoard = this.createBoard.bind(this);

        
    }


    changeDivisionHandler = (event) => {
        this.setState({division: event.target.value});
    }

    changeDepartmentHandler = (event) => {
        this.setState({department: event.target.value});
    }

    changeCategoryHandler = (event) => {
        this.setState({category: event.target.value});
    }

    changeTitleHandler = (event) => {
        this.setState({title: event.target.value});
    }

    changeContentsHandler = (event) => {
        this.setState({contents: event.target.value});
    }

    changeStudentidHandler = (event) => {
        this.setState({studentid: event.target.value});
    }

    

    createBoard = (event) => {
        event.preventDefault();
        let board = {
            division: this.state.division,
            department: this.state.department,
            category: this.state.category,
            answercontents: this.state.answercontents,
            answer: 0,
            title: this.state.title,
            contents: this.state.contents,
            studentid: this.state.studentid
        };
        console.log("board => "+ JSON.stringify(board));
        if (this.state.no === '_create') {
            BoardService.createBoard(board).then(res => {
                this.props.history.push('/board');
            });
        } else {
            BoardService.updateBoard(this.state.no, board).then(res => {
                this.props.history.push('/board');
            });
        }
    }

    cancel() {
        this.props.history.push('/board');
    }

    //페이지 타이틀을 글 작성인지 수정인지에 따라서 구분해서 출력하도록 수정 
    getTitle() {
        if (this.state.no === '_create') {
            return <h3 className="text-center">새글을 작성해주세요</h3>
        } else {
            return <h3 className="text-center">{this.state.no}글을 수정 합니다.</h3>
        }
    }

    //페이지 로딩시 글 작성이면 비어있는 폼을, 글 수정이면 글의 객체 값을 가져와서 바인딩해주도록 수정
    componentDidMount() {
        if (this.state.no === '_create') {
            return
        } else {
            BoardService.getOneBoard(this.state.no).then( (res) => {
                let board = res.data;
                console.log("board => "+ JSON.stringify(board));
                
                this.setState({
                        type: board.type,
                        title: board.title,
                        contents: board.contents,
                        studentid: board.studentid
                    });
            });
        }
    }




    render() {
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">새글을 작성해주세요</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> 학부 </label>
                                        <select placeholder="division" id="division" name="division" className="form-control1" 
                                        value={this.state.division} onChange={this.changeDivisionHandler}>
                                            <option value="산업디자인학부">산업디자인학부</option>
                                            <option value="생명환경학부">생명환경학부</option>
                                            <option value="정보미디어학부">정보미디어학부</option>
                                            <option value="비즈니스실무학부">비즈니스실무학부</option>
                                            <option value="보건의료학부">보건의료학부</option>
                                            <option value="공간시스템학부">공간시스템학부</option>
                                            <option value="자율전공학과">자율전공학과</option>
                                        </select>
                                    </div>
                                    <div className = "form-group">
                                        <label> 학과 </label>
                                        <select placeholder="department" id="department" name="department" className="form-control2" 
                                        value={this.state.department} onChange={this.changeDepartmentHandler}>
                                            <option value="학과1">학과1</option>
                                            <option value="학과2">학과2</option>
                                        </select>
                                    </div>
                                    <div className = "form-group">
                                        <label> 카테고리 </label>
                                        <select placeholder="category" id="category" name="category" className="form-control3" 
                                        value={this.state.category} onChange={this.changeCategoryHandler}>
                                            <option value="카테고리1">카테고리1</option>
                                            <option value="카테고리2">카테고리2</option>
                                        </select>
                                    </div>
                                    <div className = "form-group">
                                        <label> 제목 </label>
                                        <input type="text" placeholder="title" name="title" className="form-control" 
                                        value={this.state.title} onChange={this.changeTitleHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> 내용  </label>
                                        <textarea placeholder="contents" name="contents" className="form-control" 
                                        value={this.state.contents} onChange={this.changeContentsHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> 학번  </label>
                                        <input placeholder="studentid" name="studentid" className="form-control" 
                                        value={this.state.studentid} onChange={this.changeStudentidHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.createBoard}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft:"10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}



export default CreateBoardComponent;